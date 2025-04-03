;;Figura 35
(ns multimetodos.core
  (:gen-class))

(defmulti determinar-preco :tipo)

(defmethod determinar-preco :fruta [item]
  (* (:quantidade item) (:preco-unitario item)))

(defmethod determinar-preco :eletronico [item]
  (* (:preco-unitario item) (* (:garantia-meses item) 10)))

(defmethod determinar-preco :roupa [item]
  (* (:quantidade item) (- (:preco-unitario item) 5)))

(defn -main []
  (println "Preço fruta:" (determinar-preco {:tipo :fruta :quantidade 3 :preco-unitario 2.5}))
  (println "Preço eletrônico:" (determinar-preco {:tipo :eletronico :preco-unitario 500 :garantia-meses 12}))
  (println "Preço roupa:" (determinar-preco {:tipo :roupa :quantidade 4 :preco-unitario 50})))