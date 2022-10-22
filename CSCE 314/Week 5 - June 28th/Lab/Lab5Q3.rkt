#lang racket
(define (make-tree elem l r)
  (list elem l r))

(define (elem tree)
  (car tree))

(define (l tree)
  (cadr tree))

(define (r tree)
  (caddr tree))

(define tree1 (make-tree 1
                         (make-tree 2
                                    (make-tree 3 '() '()
                                               (make-tree 4 '() '())))))

(define (count-nodes tree)
  (cond ((null? tree) 0)
        (else (+ 1
                 (count-nodes (r tree))
                 (count-nodes (l tree))))))

(count-nodes tree1)
                              
            