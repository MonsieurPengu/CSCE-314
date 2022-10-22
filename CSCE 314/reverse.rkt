#lang racket
; Name: Ian Wang
; Section: CSCE 314 700 - Group 28
; Date: 8/11/2021
; Assignment: Reverse a list (Final Q4)

; Here we will create a recursive function that will reverse and return a list
(define (reverseHelp ls toAppend) ; Helper to make things easier
        (if (null? ls)
            toAppend (reverseHelp (cdr ls) (cons (car ls) toAppend)
                     )
        )
)

; Call the helper function and set up a new list to return the reverse
(define (reverse ls)
  (reverseHelp ls '())
)

; TEST 1
; This should return the list (1 2 3) in reverse order, (3 2 1)
(display (reverse '(1 2 3))) (newline)
; TEST 2
; This should return the list (69 420 13) in reverse order, (13 420 69)
(display (reverse '(69 420 13))) (newline)