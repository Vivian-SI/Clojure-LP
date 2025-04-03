(ns polimorfismo.gerenciador-escolar)

;; Definição de registros para representar Aluno, Professor e Disciplina
(defrecord Aluno [nota1 nota2 nota3 nota4 nome data-nascimento matricula serie])
(defrecord Professor [id nome data-nascimento horas])
(defrecord Disciplina [codigo nome carga-horaria])

;; Função para verificar se um professor já existe na lista
(defn professor-existe? [id professores]
  (some #(= (:id %) id) professores))

;; Função para cadastrar um professor
(defn cadastrar-professor []
  (println "Digite o ID do professor:")
  (let [id (Long/parseLong (read-line))
        professores (if (.exists (java.io.File. "professores.txt"))
                      (read-string (slurp "professores.txt"))
                      [])]
    (if (professor-existe? id professores)
      (println "Ja existe um professor com esse ID.")
      (do
        (println "Digite o nome do professor:")
        (let [nome (read-line)]
          (println "Digite a data de nascimento do professor:")
          (let [data-nasc (read-line)]
            (println "Digite as horas do professor:")
            (let [horas (Integer/parseInt (read-line))
                  novo-professor (->Professor id nome data-nasc horas)]
              (spit "professores.txt" (pr-str (conj professores novo-professor)))
              (println "Professor cadastrado com sucesso!"))))))))

;; Função para ler todos os professores
(defn ler-todos-professores []
  (if (.exists (java.io.File. "professores.txt"))
    (let [professores (read-string (slurp "professores.txt"))]
      (println "Professores cadastrados:")
      (doseq [prof professores]
        (println (str "ID: " (:id prof) ", Nome: " (:nome prof) ", Data Nasc: " (:data-nascimento prof) ", Horas: " (:horas prof)))))
    (println "Nenhum professor cadastrado.")))


;; Função para remover um professor
(defn remover-professor []
  (println "Digite o ID do professor a ser removido:")
  (let [id (Long/parseLong (read-line))
        professores (if (.exists (java.io.File. "professores.txt"))
                      (read-string (slurp "professores.txt"))
                      [])
        professores-atualizados (remove #(= (:id %) id) professores)]
    (if (= (count professores) (count professores-atualizados))
      (println "Nenhum professor encontrado com esse ID para remover.")
      (do
        (spit "professores.txt" (pr-str professores-atualizados))
        (println "Professor removido com sucesso.")))))

;; Função auxiliar para calcular a média do aluno
(defn calcular-media [aluno]
  (/ (+ (:nota1 aluno) (:nota2 aluno) (:nota3 aluno) (:nota4 aluno)) 4))

;; Função para listar alunos aprovados e reprovados
(defn listar-aprovados-reprovados []
  (if (.exists (java.io.File. "alunos.txt"))
    (let [alunos (read-string (slurp "alunos.txt"))
          aprovados (filter #(>= (calcular-media %) 5.0) alunos)
          reprovados (filter #(< (calcular-media %) 5.0) alunos)]
      (println "Alunos Aprovados:")
      (doseq [aluno aprovados] (println (:nome aluno)))
      (println "\nAlunos Reprovados:")
      (doseq [aluno reprovados] (println (:nome aluno))))
    (println "Nenhum aluno cadastrado.")))

;; Função para cadastrar um aluno
(defn cadastrar-aluno []
  (println "Digite a matricula do aluno:")
  (let [matricula (Long/parseLong (read-line))
        alunos (if (.exists (java.io.File. "alunos.txt"))
                 (read-string (slurp "alunos.txt"))
                 [])]
    (println "Digite o nome do aluno:")
    (let [nome (read-line)]
      (println "Digite a data de nascimento do aluno:")
      (let [data-nasc (read-line)]
        (println "Digite a serie do aluno:")
        (let [serie (read-line)]
          (println "Digite as quatro notas do aluno separadas por espaco:")
          (let [[nota1 nota2 nota3 nota4] (map #(Float/parseFloat %) (clojure.string/split (read-line) #" "))
                novo-aluno (->Aluno nota1 nota2 nota3 nota4 nome data-nasc matricula serie)]
            (spit "alunos.txt" (pr-str (conj alunos novo-aluno)))
            (println "Aluno cadastrado com sucesso!")))))))

;; Função para ler todos os alunos
(defn ler-todos-alunos []
  (if (.exists (java.io.File. "alunos.txt"))
    (let [alunos (read-string (slurp "alunos.txt"))]
      (println "Alunos cadastrados:")
      (doseq [aluno alunos]
        (println (str "Matricula: " (:matricula aluno) ", Nome: " (:nome aluno) ", Serie: " (:serie aluno)))))
    (println "Nenhum aluno cadastrado.")))

;; Função para remover um aluno
(defn remover-aluno []
  (println "Digite a matricula do aluno a ser removido:")
  (let [matricula (Long/parseLong (read-line))
        alunos (if (.exists (java.io.File. "alunos.txt"))
                 (read-string (slurp "alunos.txt"))
                 [])
        alunos-atualizados (remove #(= (:matricula %) matricula) alunos)]
    (if (= (count alunos) (count alunos-atualizados))
      (println "Nenhum aluno encontrado com essa matricula para remover.")
      (do
        (spit "alunos.txt" (pr-str alunos-atualizados))
        (println "Aluno removido com sucesso.")))))

;; Função para cadastrar uma disciplina
(defn cadastrar-disciplina []
  (println "Digite o código da disciplina:")
  (let [codigo (Long/parseLong (read-line))
        disciplinas (if (.exists (java.io.File. "disciplinas.txt"))
                      (read-string (slurp "disciplinas.txt"))
                      [])]
    (println "Digite o nome da disciplina:")
    (let [nome (read-line)]
      (println "Digite a carga horaria da disciplina:")
      (let [carga-horaria (Integer/parseInt (read-line))
            nova-disciplina (->Disciplina codigo nome carga-horaria)]
        (spit "disciplinas.txt" (pr-str (conj disciplinas nova-disciplina)))
        (println "Disciplina cadastrada com sucesso!")))))

;; Função para ler todas as disciplinas
(defn ler-todas-disciplinas []
  (if (.exists (java.io.File. "disciplinas.txt"))
    (let [disciplinas (read-string (slurp "disciplinas.txt"))]
      (println "Disciplinas cadastradas:")
      (doseq [disc disciplinas]
        (println (str "Codigo: " (:codigo disc) ", Nome: " (:nome disc) ", Carga Horaria: " (:carga-horaria disc) " horas"))))
    (println "Nenhuma disciplina cadastrada.")))

;; Função para remover uma disciplina
(defn remover-disciplina []
  (println "Digite o codigo da disciplina a ser removida:")
  (let [codigo (Integer/parseInt (read-line))
        disciplinas (if (.exists (java.io.File. "disciplinas.txt"))
                      (read-string (slurp "disciplinas.txt"))
                      [])
        disciplinas-atualizadas (remove #(= (:codigo %) codigo) disciplinas)]
    (if (= (count disciplinas) (count disciplinas-atualizadas))
      (println "Nenhuma disciplina encontrada com esse codigo para remover.")
      (do
        (spit "disciplinas.txt" (pr-str disciplinas-atualizadas))
        (println "Disciplina removida com sucesso.")))))
