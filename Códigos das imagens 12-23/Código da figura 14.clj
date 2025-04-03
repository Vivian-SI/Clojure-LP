;;Código da figura 14
(def ^: dynamic *z* 30)
(binding [*z* 40]
   (println "Valor de *z* dentro de binding:" *z*))
(println "Valor de *z* fora de binding:" *z*)
