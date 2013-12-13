(ns mikera.spectral.core
  (:use [overtone core]))


;; ==================================================
;; some instruments

(definst foo [] (saw 220))
 
(definst trem [freq 440 depth 10 rate 6 length 3]
    (* 0.3
       (line:kr 0 1 length FREE)
       (saw (+ freq (* depth (sin-osc:kr rate))))))
 
(definst bar [freq 440 depth 10 rate 6 length 10]
    (* 2.0
       (sin-osc:kr rate)
     (line:kr 1 1 length FREE)
       (sound-in)))
  
(definst oksaw [note 60 velocity 100 gate 1 bass-presence 0]
  (let [freq (midicps note)
        amp 0.33
        snd (sin-osc freq)
        env (env-gen (adsr 0 0.6 0.9 0.9) gate :action FREE)
        del (* (/ 1 (* 2 freq)) (+ 0.25 (* 0.25 (sin-osc 1)))) 
        dfreq1 (* freq (Math/pow 2 (/ 40 1000)))
        dfreq2 (* freq (Math/pow 2 (/ 22 1000)))
        cutoff-env (env-gen (adsr 0.25 1 1 2) gate)
        snd (lpf 
              (+
                (* bass-presence amp (sin-osc (/ freq 2)))
                (*  amp (saw freq))
                (delay-l (* amp (saw dfreq1)) 1 (/ del 2))
                (delay-l (* amp (saw dfreq2)) 1 (/ del 3))) 
              (* 16000 cutoff-env))
        snd (b-low-shelf snd 80 1 10)
        snd (b-peak-eq snd 800 1 0)
        snd (b-hi-shelf snd 2000 1 5)]
      (* env snd)))