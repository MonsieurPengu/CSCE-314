#lang racket
(define (count-leaf tree)
  (if (leaf? tree)
      l
      (count-leaf (child tree))))
