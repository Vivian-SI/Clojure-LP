;map aplica uma função a cada elemento de uma coleção
(map inc [1 2 3]) ;; => (2 3 4) (Incrementa cada número)
(map str ["A" "B" "C"]) ;; => ("A" "B" "C") (Concatena strings)

;filter filtra elementos de uma coleção com base em uma condição
(filter even? [1 2 3 4]) ;; => (2 4) (Filtra números pares)

;reduce reduz uma coleção a um único valor aplicando uma função cumulativa
(reduce + [1 2 3 4]) ;; => 10 (Soma todos os números)
(reduce * [2 3 4]) ;; => 24 (Multiplica todos os números)