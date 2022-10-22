#lang racket
(define (list-of-squares n)
  (let loop ((i n ) (res '()))
    (if (< i 0 )
        res
        (loop (- i 1) (cons (* i i) res)))))

(list-of-squares 9)