(ns polimorfismo.interface
  (:require [polimorfismo.gerenciador-escolar :as g])
  (:gen-class))

;; Função para exibir o menu principal
(defn menu []
  (println "\nEscolha uma opcao:")
  (println "1. Cadastrar Aluno")
  (println "2. Ler Todos os Alunos")
  (println "3. Remover Aluno")
  (println "4. Listar alunos aprovados e reprovados")
  (println "5. Cadastrar Professor")
  (println "6. Ler Todos os Professores")
  (println "7. Remover Professor")
  (println "8. Cadastrar Disciplina")
  (println "9. Ler Todas as Disciplinas")
  (println "10. Remover Disciplina")
  (println "11. Modificar Disciplina")
  (println "12. Modificar Professor")
  (println "13. Modificar Aluno")
  (println "14. Sair")
  (println "Opcao: ")
  (let [opcao (read-line)]
    (case opcao
      "1" (do (g/cadastrar-aluno) (menu))
      "2" (do (g/ler-todos-alunos) (menu))
      "3" (do (g/remover-aluno) (menu))
      "4" (do (g/listar-aprovados-reprovados) (menu))
      "5" (do (g/cadastrar-professor) (menu))
      "6" (do (g/ler-todos-professores) (menu))
      "7" (do (g/remover-professor) (menu))
      "8" (do (g/cadastrar-disciplina) (menu))
      "9" (do (g/ler-todas-disciplinas) (menu))
      "10" (do (g/remover-disciplina) (menu))
      "11" (do (g/remover-disciplina) (g/cadastrar-disciplina) (menu))
      "12" (do (g/remover-professor) (g/cadastrar-professor) (menu))
      "13" (do (g/remover-aluno) (g/cadastrar-aluno) (menu))
      "14" (println "Saindo...")
      (do (println "Opcao invalida, tente novamente.") (menu)))))

;; Função principal para iniciar o sistema
(defn -main []
  (println "Bem-vindo ao Gerenciador Escolar")
  (menu))