;Para mapas
(get {:a 1 :b 2} :a) ;; => 1 (Valor associado à chave :a)
(:b {:a 1 :b 2}) ;; => 2 (Acesso direto via keyword)

(assoc {:a 1} :b 2) ;; => {:a 1, :b 2} (Adiciona um par chave-valor)
(dissoc {:a 1 :b 2} :a) ;; => {:b 2} (Remove a chave :a)