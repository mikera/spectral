(ns mikera.spectral.core
  (:use [overtone core])
  (:require [clojure.core.matrix :as mat]))

(defonce boot (boot-external-server))

(require '[mikera.spectral.inst :as inst])

(defonce buf (buffer 44100)) ;; create a buffer to store the audio 

(def snare (sample (freesound-path 26903))) 

  ;; ============================================
  ;; buffer fun
  
(defsynth bus->buf [bus 20 buf 0] 
      (record-buf (in bus) buf)) 

(defsynth barf [out-bus 20] (out out-bus (sin-osc 400)))

(do
  (bus->buf 20 buf)
  (barf)
  (Thread/sleep 1000)
  (stop))

(take 10 (buffer-read buf))