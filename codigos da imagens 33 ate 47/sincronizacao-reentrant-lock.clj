;;Figura 46
(ns sincronizacao-reentrant-lock.core
  (:gen-class)
  (:import [java.util.concurrent.locks ReentrantLock]))

(def meu-lock (ReentrantLock.))
(def contador (atom 0))

(defn incrementar []
  (.lock meu-lock)
  (try
    (swap! contador inc)
  (finally
    (.unlock meu-lock))))

(defn -main []
  (let [futuros (doall (repeatedly 10 #(future (incrementar))))]
    (doseq [f futuros] @f)
    (println "Valor final do contador:" @contador)))