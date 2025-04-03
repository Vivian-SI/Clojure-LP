;;Código da figura 15
(ns exemplo.datomic
	(:require [datomic.api :as d])) ; Importa a API do Datomic

;; URL do banco de dados (pode ser local ou remoto)
(def uri "datomic:mem://meu-banco")

;; Criação do banco de dados
(d/create-database uri)

;; Conexão ao banco de dados
(def conn (d/connect uri))

;; Transação de dados
(def dados-iniciais
  [{:db/ib (d/tempid :db.part/user)
    : nome "Lucas"
    :idade 30}])

;; Submete os dados ao banco
@(d/transact conn dados-iniciais)

;; Consulta os dados
(def consulta
  '[:find ?e ?nome ?idade
    :where [?e :nome ?nome]
	   [? e : idade ?idade]])

