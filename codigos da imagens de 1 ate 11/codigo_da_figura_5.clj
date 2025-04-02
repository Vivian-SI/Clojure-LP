; Para listas e Vetores
(first [1 2 3]) ;; => 1 (Primeiro elemento)
(last [1 2 3]) ;; => 3 (Último elemento)
(rest [1 2 3]) ;; => (2 3) (Resto da lista)

(conj [1 2] 3) ;; => [1 2 3] (Adiciona no final do vetor)
(conj '(1 2) 3) ;; => (3 1 2) (Adiciona no início da lista)