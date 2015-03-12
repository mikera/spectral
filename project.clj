(defproject net.mikera/spectral "0.0.1-SNAPSHOT"
  :description "Spectral experiments to visualize FFT with overtone, vectorz und imagez."
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]

  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]
                 [overtone "0.9.1"]
                 [net.mikera/vectorz-clj "0.29.0"]
                 [net.mikera/imagez "0.5.0"]]
  :jvm-opts ["-Xmx2048m"])
