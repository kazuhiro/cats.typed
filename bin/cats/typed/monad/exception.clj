(ns cats.typed.monad.exception
  (:require [clojure.core.typed :as t]))

(t/ann-datatype [[a :variance :covariant]]
                cats.monad.exception.Success
                [v :- a])

(t/ann-datatype [[a :variance :invariant :> Throwable]]
                cats.monad.exception.Failure
                [v :- a])

(t/defalias Success
  (t/TFn [[x :variance :covariant]]
         (cats.monad.exception.Success x)))

(t/defalias Failure
  (t/TFn [[x :variance :invariant :> Throwable]]
         (cats.monad.exception.Failure x)))

(t/defalias MException
  (t/TFn [[x :variance :covariant]]
         (t/U (Success x) (Failure Throwable))))

(t/ann ^:no-check cats.monad.exception/throw-exception
       [String -> IllegalArgumentException])

(t/ann ^:no-check cats.monad.exception/exception?
       [t/Any -> Boolean])

(t/ann ^:no-check cats.monad.exception/throwable?
       [t/Any -> Boolean])

(t/ann ^:no-check cats.monad.exception/success
       (t/All [x] [x -> (Success x)]))

(t/ann ^:no-check cats.monad.exception/failure
       [Throwable -> (Failure Throwable)])

(t/ann ^:no-check cats.monad.exception/success?
       (t/All [x] [(MException x) -> Boolean]))

(t/ann ^:no-check cats.monad.exception/failure?
       (t/All [x] [(MException x) -> Boolean]))

(t/ann ^:no-check cats.monad.exception/extract
       (t/All [x] (t/IFn [(MException x) -> x]
                         [(MException x) x -> x])))

(t/ann ^:no-check cats.monad.exception/exec-try-on
       (t/All [y] [(t/IFn [-> y]) -> (MException y)]))

(t/ann ^:no-check cats.monad.exception/exec-try-or-else
       (t/All [y] [(t/IFn [-> y]) y -> (MException y)]))

(t/ann ^:no-check cats.monad.exception/exec-try-or-recover
       (t/All [y] [(t/IFn [-> y]) (t/IFn [(Failure y) -> y]) -> (MException y)]))

(t/ann ^:no-check cats.monad.exception/wrap
       (t/All [x y] (t/IFn [(t/IFn [x -> y]) -> (MException y)]
                           [(t/IFn [-> y]) -> (MException y)])))
