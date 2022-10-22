#lang racket
(define (clone a n)
  (cond
    [(= n 0) '()]
    [else (cons a (clone a (- n 1)))]
    )

  )

(clone 3 7)
(clone 7 3)
