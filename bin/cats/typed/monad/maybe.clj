(ns cats.typed.monad.maybe
  (:require [clojure.core.typed :as t]
            [cats.monad.maybe :as maybe]))

(t/ann-datatype [[a :variance :covariant]]
                cats.monad.maybe.Just
                [v :- a])

(t/ann-datatype [[a :variance :covariant]]
                cats.monad.maybe.Nothing
                [v :- a])

(t/defalias Just
  (t/TFn [[x :variance :covariant]] (cats.monad.maybe.Just x)))

(t/defalias Nothing
  (t/TFn [[x :variance :covariant]] (cats.monad.maybe.Nothing x)))

(t/defalias Maybe
  (t/TFn [[x :variance :covariant]] (t/U (Just x) (Nothing x))))

(t/ann ^:no-check cats.monad.maybe/maybe?
       [t/Any -> Boolean])

(t/ann ^:no-check cats.monad.maybe/just?
       [t/Any -> Boolean])

(t/ann ^:no-check cats.monad.maybe/nothing?
       [t/Any -> Boolean])

(t/ann ^:no-check cats.monad.maybe/just
       (t/All [x] [x -> (Just x)]))

(t/ann ^:no-check cats.monad.maybe/nothing
       (t/All [x] [x -> (Nothing x)]))

(t/ann ^:no-check cats.monad.maybe/from-maybe
       (t/All [x] [(Maybe x) -> (t/Option x)]))


(t/ann ^:no-check cats.monad.maybe/maybe-t
       (t/All [x] [(Maybe x) -> (Maybe x)]))

(t/ann ^:no-check cats.monad.maybe/maybe
       (t/All [x y] [y (Maybe x) [x -> y] -> y]))

(t/ann ^:no-check cats.monad.maybe/seq->maybe
       (t/All [x] [(t/Seq x) -> (Maybe x)]))

(t/ann ^:no-check cats.monad.maybe/maybe-seq
       (t/All [x] [(Maybe x) -> (t/Seq x)]))

(t/ann ^:no-check cats.monad.maybe/cat-maybes
       (t/All [x] [(t/Seq (Maybe x)) -> (t/Seq x)]))

(t/ann ^:no-check cats.monad.maybe/map-maybe
       (t/All [x y] [[x -> (Maybe y)] (t/Seq x) -> (t/Seq (Maybe x))]))
