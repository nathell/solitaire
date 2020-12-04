# solitaire

A training repository for the [re-frame](https://github.com/day8/re-frame) workshop held before [re:Clojure 2020](https://reclojure.org).

## Getting Started

You will need [Leiningen](https://leiningen.org/#install), [Node.js](https://nodejs.org/), and [NPM](https://docs.npmjs.com/cli/npm).
npm is included as part of node.js, so you don’t need to install it separately.

For reference, I’ve been using Leiningen 2.9.3 on Java 11.0.7 OpenJDK 64-Bit Server VM, node 14.9.0, and npm 6.4.8 on macOS to prepare
the workshop – but you should be fine on any platform with reasonably recent dependencies.

## Before the workshop

Please clone this repository and run `lein watch`. If all goes well, you should eventually see a message similar to this:

```
shadow-cljs - HTTP server available at http://localhost:8280
shadow-cljs - server version: 2.11.7 running at http://localhost:9630
shadow-cljs - nREPL server started on port 8777
shadow-cljs - watching build :app
[:app] Configuring build.
[:app] Compiling ...
[:app] Build completed. (527 files, 527 compiled, 0 warnings, 5.20s)
```

At this point, you should be able to visit [http://localhost:8280](http://localhost:8280) in your browser. If you see the
skeleton app, congratulations! You are ready for the workshop.

Please note that there may be updates pushed to the repo after you clone it, so I’ll ask everybody to
`git pull` just before we start, so that we’re all working with the same code.

## During the workshop

If you have trouble with anything, please contact me at dj@danieljanus.pl. I’m also `djanus` on Clojurians Slack (note: there are two
accounts by that name – both are mine but I lost access to one of them – so please message the one whose status message reads
“Your re-frame workshop host”), or you can ping me on [Twitter](https://twitter.com/nathell).

The slides can be found at [http://danieljanus.pl/talks/2020-reclojure/](http://danieljanus.pl/talks/2020-reclojure/).

## After the workshop

I’d be grateful if you take the time to fill a short [survey](http://tinyurl.com/re-frame-workshop-survey). It’s my first workshop,
so I want to know what I can improve for future ones!
