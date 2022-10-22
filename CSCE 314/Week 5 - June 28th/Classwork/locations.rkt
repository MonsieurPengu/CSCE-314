#lang racket
children (car (children (cadr (children world-tree))))
;returns the children of california
; berkley san_francisco gilroy
car (children (car (children (cadr (children world-tree)))))
; returns the first child of california
;  Berkley
datum (car (children (car (children (cadr (children world-tree))))))
; returns the first child of california without any of the children of berkley
;  Berkley

(make-node 'Japan
           (list (make-node 'Nihon '())
                 (make-node 'Tokyo '())
                 (make-node 'Kwansei '())
            )
)
(make-node 'texas
           (list (make-node 'college_station '())
                 (make-node 'austin '())
            )
)
       