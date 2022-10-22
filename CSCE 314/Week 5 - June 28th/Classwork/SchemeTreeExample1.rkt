#lang racket
; Constructor
(define (make-node datum children)
  (cons datum children))
; Datum
(define (datum node)
  (car node))
; Children
(define (children node)
  (cdr node))