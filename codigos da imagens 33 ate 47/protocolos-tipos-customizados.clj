;;Figura 34 
(ns protocolos-tipos-customizados.core
  (:gen-class))

(defprotocol Saudacao
  (saudar [this]))

(defrecord Pessoa [nome]
  Saudacao
  (saudar [this] (str "Olá, meu nome é " nome "!")))

(defrecord Animal [especie]
  Saudacao
  (saudar [this] (str "Eu sou um " especie " e digo olá!")))

(defn -main []
  (println (saudar (->Pessoa "Lucas")))
  (println (saudar (->Animal "cachorro"))))