(ns cats.typed-test
  (:require [clojure.test :refer :all]
            [clojure.core.typed :as t]))

(deftest either-monad
  (is (t/check-ns '[cats.typed.monad.either-test])))

(deftest exception-monad
  (is (t/check-ns '[cats.typed.monad.exception-test])))

(deftest maybe-monad
  (is (t/check-ns '[cats.typed.monad.maybe-test])))

(deftest identity-monad
  (is (t/check-ns '[cats.typed.monad.identity-test])))
