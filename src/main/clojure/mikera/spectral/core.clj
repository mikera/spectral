(ns mikera.spectral.core
  (:use [overtone core])
  (:require [spectral.inst :as inst]))

(defonce boot (boot-external-server))

(defonce buf (buffer 44100)) ;; create a buffer to store the audio 

  ;; ============================================
  ;; buffer fun
  
(defsynth my-saw []
  (record-buf (saw 220) buf :action :free, :loop 0))


