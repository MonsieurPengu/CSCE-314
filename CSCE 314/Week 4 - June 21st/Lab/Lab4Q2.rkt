#lang racket
(define (trafficLight color)

  (cond

    ((equal? "green") (display "It's green\n"))

    ((equal? "yellow") (display "It's yellow!\n"))

    ((equal? "red") (display "stop\n"))

    (else (display "wrong color\n"))
 
    )

  )

 

(trafficLight "blue")

(trafficLight "green")