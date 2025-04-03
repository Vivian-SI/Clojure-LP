;;(ns NOME_DO_PROJETO.codigosDasFiguras24-32
;;  (:gen-class))

;;Código da figura 24
;;(defn -main []
;;    (let [resultado (delay (printin "Executando...") (* 2 5))]
;;        (println "Ainda não executou")
;;        (printin "Resultado:" (force resultado))))
        ;; saída no prompt será:
        ;;                       Ainda não executou
        ;;                       Executando...
        ;;                       Resultado: 10

;;Código da figura 25
;;(defn -main []
;;  (let [resultado (future (do (Thread/sleep 2000) (* 2 10)))] ;;Variável local com 'let"
;;      (printin "Executando em paralelo...")
;;      (println "Resultado:" @resultado))) ; Aguardando a execução assincrona

;;código da figura 26
;; Função que gera uma sequência infinita de números 
;;(defn numeros-infinito [n]
;;  (lazy-seq (cons n (numeros-infinito (inc n)))))

;;(defn -main []
;;  (printin (take 5 (numeros-infinito 1)))) i; Exibe os primeiros 5 números da sequência

;;código da figura 27
;;(defn soma
;;  "Função que soma dois números."
;;  [a b]
;;  (+ a b))
;;(defn -main
;;  "Função principal que será executada com 'lein run'."
;;  []
;;; (printin "Resultado ansioso:" (soma (* 2 3) (+ 4 1))))

;;código da figura 28
;;(defn quadrado
;;  "Função que calcula o quadrado de um número." 
;;  [n]
;;  (printin (str "Calculando o quadrado de " n) )
;;  (* n n))
;; Criando uma sequência infinita de quadrados 
;;(def quadrados (map quadrado (range)))
;;(defn -main
;;  "Função principal que será executada com 'lein run'."
;;  []
;;  (printin "Pegando apenas os dois primeiros valores...")
;;  (dorun (take 2 quadrados))) ;; Forca a avaliação preguiçosa

;;código da figura 29
;;(defmulti area :forma)
;;(demethod area :círculo [c]
;;  (* Math/PI (:raio c) (:raio c)))
;;(demethod area :retângulo [r] 
;;  (* (:largura r) (:altura r)))
;;(area {:forma :círculo :raio 5}) ; Resultado: 78.53981633974483
;;(area {: forma :retângulo :largura 4 :altura 6}) ; Resultado: 24

;;código da figura 30	
;;(defprotocol Forma
;;  (area [this]))
;;defrecord Circulo [raio] 
;;  Forma
;;  (area [this] (* Math/PI (* raio raio))))
;;(defrecord Retangulo [largura altura]
;;  Forma
;;  (area [this] (* largura altura)))
;;
;;(area (-›Circulo 5)) ; Resultado: 78.53981633974483
;;(area (->Retangulo 4 6)) ; Resultado: 24

;;código da figura 31	
;;(defn aplicar-funcao [f x]
;;  (f x) )
;;(aplicar-funcao inc 5) ; Retorna: 6 
;;(aplicar-funcao str 123) ; Retorna: "123"

;;código da figura 32
;;(defmulti calcular-area :tipo)
;;(defmethod calcular-area :círculo [c]
;;  (let [f #(* Math/PI (* (:raio %) (:raio %)))]
;;  (F c) ))
;;(defmethod calcular-area :retângulo [r]
;;  (let [f #(* (:largura %) (:altura %))]
;;  (fr)))
;;(calcular-area {:tipo :círculo :raio 5}) ; Resultado: 78.53981633974483 
;;(calcular-area {:tipo :retângulo :largura 4 :altura 6}) ; Resultado: 24