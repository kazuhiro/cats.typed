(ns cats.typed.monad.either
  (:require [clojure.core.typed :as t]
            [cats.monad.either :as either]))

(t/ann-datatype [[a :variance :covariant]]
              cats.monad.either.Left
              [v :- a])

(t/ann-datatype [[a :variance :covariant]]
              cats.monad.either.Right
              [v :- a])

(t/defalias Left
  (t/TFn [[x :variance :covariant]] (cats.monad.either.Left x)))

(t/defalias Right
  (t/TFn [[x :variance :covariant]] (cats.monad.either.Right x)))

(t/defalias Either
  (t/TFn [[x :variance :covariant]] (t/U (Left x) (Right x))))

(t/ann ^:no-check cats.monad.either/left
       (t/All [x] [x -> (cats.monad.either.Left x)]))

(t/ann ^:no-check cats.monad.either/right
       (t/All [x] [x -> (cats.monad.either.Right x)]))

(t/ann ^:no-check cats.monad.either/left?
       (t/All [x] [(Either x) -> Boolean]))

(t/ann ^:no-check cats.monad.either/right?
       (t/All [x] [(Either x) -> Boolean]))

(t/ann ^:no-check cats.monad.either/branch-left
       (t/All [x y] [(Either x) (t/IFn [x -> y]) -> y]))

(t/ann ^:no-check cats.monad.either/branch-right
       (t/All [x y] [(Either x) (t/IFn [x -> y]) -> y]))

(t/ann ^:no-check cats.monad.either/branch
       (t/All [x y] [(Either x) (t/IFn [x -> y]) (t/IFn [x -> y]) -> y]))

(t/ann ^:no-check cats.monad.either/lefts
       (t/All [x] [(t/Seq (Either x)) -> (t/Seq x)]))

(t/ann ^:no-check cats.monad.either/rights
       (t/All [x] [(t/Seq (Either x)) -> (t/Seq x)]))

(t/ann ^:no-check cats.monad.either/first-left
       (t/All [x] [(t/Seq (Either x)) -> (t/Option x)]))

(t/ann ^:no-check cats.monad.either/first-right
       (t/All [x] [(t/Seq (Either x)) -> (t/Option x)]))

(t/ann ^:no-check cats.monad.either/invert
       (t/All [x] (t/IFn [(Left x) -> (Right x)]
                         [(Right x) -> (Left x)]
                         [(Either x) -> (Either x)])))
