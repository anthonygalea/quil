(ns quil.snippets.shape.loading-and-displaying
  (:require #?(:clj [quil.snippets.macro :refer [defsnippet]])
            [quil.core :as q :include-macros true]
            quil.snippets.all-snippets-internal)
  #?(:cljs
     (:use-macros [quil.snippets.macro :only [defsnippet]])))

#?(:clj
   (defsnippet load-shape
     "load-shape"
     {:renderer :p2d}

     (let [sh #?(:clj (q/load-shape "https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg")
                 :cljs (q/load-shape "Heckert_GNU_white.svg"))]
       (q/shape sh 0 0 500 500))))

#?(:clj
   (defsnippet shape
     "shape"
     {:renderer :p2d}

     (let [sh #?(:clj (q/load-shape "https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg")
                 :cljs (q/load-shape "Heckert_GNU_white.svg"))]
       (q/shape sh)
       (q/shape sh 100 100)
       (q/shape sh 300 300 200 200))))

#?(:clj
   (defsnippet shape-mode
     "shape-mode"
     {:renderer :p2d}

     (let [sh #?(:clj (q/load-shape "https://upload.wikimedia.org/wikipedia/en/2/22/Heckert_GNU_white.svg")
                 :cljs (q/load-shape "Heckert_GNU_white.svg"))]
       (q/stroke-weight 5)
       (q/stroke 255 0 0)

       (q/shape-mode :corner)
       (q/shape sh 20 20 200 200)
       (q/point 20 20)

       (q/shape-mode :corners)
       (q/shape sh 270 20 370 120)
       (q/point 270 20)
       (q/point 370 120)

       (q/shape-mode :center)
       (q/shape sh 100 350 150 150)
       (q/point 100 350))))
