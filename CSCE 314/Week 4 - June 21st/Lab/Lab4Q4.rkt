#lang racket
(define (replicate-help lst n)
    (cond ((= n 0) '())
          (else (cons lst (replicate-help lst (- n 1 ))))))

(define (replicate ret-lst lst)
    (cond
      [
       (null? ret-lst) ret-lst]
      [
       else (append (replicate-help (car ret-lst) lst) (replicate (cdr ret-lst) lst))
      ]
     )
)

(replicate '(1 2 3) 4)
