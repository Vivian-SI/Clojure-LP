;;Figura 36
(ns macros.core
  (:gen-class))

(defmacro unless[cond & body]
  `(if (not ~cond)
      (do ~@body)))

(defn -main []
  (unless false
    (println "A condição é falsa!")))