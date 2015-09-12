(ns cats.typed.monad.either-test
  (:require [clojure.test :refer :all]
            [cats.monad.either :as either]
            [cats.typed.monad.either :refer :all]
            [clojure.core.typed :as t]))

(t/ann typed-lefts [(t/Seq (Either Integer)) -> (t/Seq Integer)])
(defn typed-lefts [col] (either/lefts col))

(t/ann typed-rights [(t/Seq (Either Integer)) -> (t/Seq Integer)])
(defn- typed-rights [col] (either/rights col))

(t/ann typed-first-left [(t/Seq (Left Integer)) -> (t/Option Integer)])
(defn- typed-first-left [col] (either/first-left col))

(t/ann typed-first-right [(t/Seq (Right Integer)) -> (t/Option Integer)])
(defn- typed-first-right [col] (either/first-right col))

(t/ann typed-left [Integer -> (cats.monad.either.Left Integer)])
(defn- typed-left [x] (either/left 1))

(t/ann typed-right [Integer -> (cats.monad.either.Right Integer)])
(defn- typed-right [x] (either/right 1))

(t/ann typed-branch-left (t/All [x] [(Left Integer) [Integer -> String] -> String]))
(defn- typed-branch-left [e lf] (either/branch-left e lf))

(t/ann typed-branch-right (t/All [x] [(Right Integer) [Integer -> String] -> String]))
(defn- typed-branch-right [e lf] (either/branch-right e lf))

(t/ann typed-invert-left [(Left Integer) -> (Right Integer)])
(defn- typed-invert-left [e] (either/invert e))

(t/ann typed-invert-right [(Right Integer) -> (Left Integer)])
(defn- typed-invert-right [e] (either/invert e))

(t/ann typed-invert-either [(Either Integer) -> (Either Integer)])
(defn- typed-invert-either [e] (either/invert e))
