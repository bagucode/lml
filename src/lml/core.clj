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
       (symbol? tok)   {:tok :identifier, :val tok}
       :else           {:tok :illegal, :val tok})
      (parse (next tok-seq))))))

(defn gettok [tok-seq]
  (when-let [tok (first tok-seq)]
    ))

