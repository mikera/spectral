(defproject net.mikera/spectral "0.0.1-SNAPSHOT"
  :description "Spectral experiments to visualize FFT with overtone, vectorz und imagez."
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [overtone "0.9.1"]
                 [net.mikera/vectorz-clj "0.17.0"]
                 [net.mikera/vectorz "0.25.0"]
                 [net.mikera/core.matrix "0.16.0"]
                 [net.mikera/cljunit "0.3.0"]
                 [net.mikera/imagez "0.3.1"]]
  :jvm-opts ["-Xmx2048m"])
