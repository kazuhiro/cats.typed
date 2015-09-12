(ns cats.typed.monad.exception-test
  (:require [clojure.test :refer :all]
            [cats.typed.monad.exception :refer :all]
            [clojure.core.typed :as t]))

;; cannot require in ns macro due to conditonal reader
;; in cats.monad.exception definition
;; which halts processing in core.typed
(require '[cats.monad.exception :as exception])

(t/ann typed-throw-exception [String -> IllegalArgumentException])
(defn- typed-throw-exception [s] (exception/throw-exception s))

(t/ann typed-throwable? [(MException Integer) -> Boolean])
(defn- typed-throwable? [e] (exception/throwable? e))

(t/ann typed-success [Integer -> (Success Integer)])
(defn- typed-success [v] (exception/success v))

;;(t/ann typed-failure [Integer -> (Failure Integer)])
;;(defn- typed-failure [v] (exception/failure v))

(t/ann typed-failure [IllegalStateException -> (Failure Throwable)])
(defn- typed-failure [v] (exception/failure v))

(t/ann typed-failure? [(MException Integer)-> Boolean])
(defn- typed-failure? [e] (exception/failure? e))

(t/ann typed-extract [(MException Integer) Integer -> Integer])
(defn- typed-extract [e d] (exception/extract e d))

(t/ann typed-exec-try-on [(t/IFn [-> Integer]) -> (MException Integer)])
(defn- typed-exec-try-on [f] (exception/exec-try-on f))

(t/ann typed-try-on [Integer -> (MException Integer)])
(defn- typed-try-on [v] (exception/try-on v))

(t/ann typed-exec-try-or-else
       [(t/IFn [-> Integer]) Integer -> (MException Integer)])
(defn- typed-exec-try-or-else [f d] (exception/exec-try-or-else f d))

(t/ann typed-try-or-else
       [Integer Integer -> (MException Integer)])
(defn- typed-try-or-else [v1 v2] (exception/try-or-else v1 v2))


(t/ann typed-exec-try-or-recover
       [(t/IFn [-> Integer]) (t/IFn [(Failure Integer) -> Integer]) -> (MException Integer)])
(defn- typed-exec-try-or-recover [f r] (exception/exec-try-or-recover f r))

(t/ann typed-try-or-recover
       [Integer (t/IFn [(Failure Integer) -> Integer]) -> (MException Integer)])
(defn- typed-try-or-recover [v r] (exception/try-or-recover v r))

(t/ann typed-wrap [(t/IFn [Integer -> String]) -> (MException String)])
(defn- typed-wrap [f] (exception/wrap f))
