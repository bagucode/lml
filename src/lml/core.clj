(ns lml.core)

(defn parse-call [form]
  
       (= 'def tok)    (parse-def tok-seq)
       (= 'extern tok) (parse-extern tok-seq)
  )

(defn parse-def [form]
  )

(defn parse [tok-seq]
  (when-let [tok (first tok-seq)]
    (lazy-seq
     (cons
      (cond
       (seq? tok)      (parse-call tok-seq)
       (number? tok)   {:tok :number, :val tok}
       (symbol? tok)   {:tok :symbol, :val tok}
       :else           {:tok :illegal, :val tok})
      (parse (next tok-seq))))))

(defn gettok [tok-seq]
  (when-let [tok (first tok-seq)]
    ))

;; # Compute the x'th fibonacci number.
;; def fib(x)
;;   if x < 3 then
;;     1
;;   else
;;     fib(x-1)+fib(x-2)

;; # This expression will compute the 40th number.
;; fib(40)

;; (def fib (x)
;;   (if (< x 3)
;;     1
;;     (+ (fib (- x 1)) (fib (- x 2)))))

