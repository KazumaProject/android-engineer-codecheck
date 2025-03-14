package jp.co.yumemi.android.code_check.util

object LanguageColors {
    private val colors: Map<String, String?> = mapOf(
        "1C Enterprise" to "#814CCC",
        "2-Dimensional Array" to "#38761D",
        "4D" to "#004289",
        "ABAP" to "#E8274B",
        "ABAP CDS" to "#555e25",
        "ActionScript" to "#882B0F",
        "Ada" to "#02f88c",
        "Adblock Filter List" to "#800000",
        "Adobe Font Metrics" to "#fa0f00",
        "Agda" to "#315665",
        "AGS Script" to "#B9D9FF",
        "AIDL" to "#34EB6B",
        "AL" to "#3AA2B5",
        "Alloy" to "#64C800",
        "Alpine Abuild" to "#0D597F",
        "Altium Designer" to "#A89663",
        "AMPL" to "#E6EFBB",
        "AngelScript" to "#C7D7DC",
        "Answer Set Programming" to "#A9CC29",
        "Ant Build System" to "#A9157E",
        "Antlers" to "#ff269e",
        "ANTLR" to "#9DC3FF",
        "ApacheConf" to "#d12127",
        "Apex" to "#1797c0",
        "API Blueprint" to "#2ACCA8",
        "APL" to "#5A8164",
        "Apollo Guidance Computer" to "#0B3D91",
        "AppleScript" to "#101F1F",
        "Arc" to "#aa2afe",
        "AsciiDoc" to "#73a0c5",
        "ASL" to null,
        "ASP.NET" to "#9400ff",
        "AspectJ" to "#a957b0",
        "Assembly" to "#6E4C13",
        "Astro" to "#ff5a03",
        "Asymptote" to "#ff0000",
        "ATS" to "#1ac620",
        "Augeas" to "#9CC134",
        "AutoHotkey" to "#6594b9",
        "AutoIt" to "#1C3552",
        "Avro IDL" to "#0040FF",
        "Awk" to "#c30e9b",
        "B4X" to "#00e4ff",
        "Ballerina" to "#FF5000",
        "BASIC" to "#ff0000",
        "Batchfile" to "#C1F12E",
        "Beef" to "#a52f4e",
        "Befunge" to null,
        "Berry" to "#15A13C",
        "BibTeX" to "#778899",
        "Bicep" to "#519aba",
        "Bikeshed" to "#5562ac",
        "Bison" to "#6A463F",
        "BitBake" to "#00bce4",
        "Blade" to "#f7523f",
        "BlitzBasic" to "#00FFAE",
        "BlitzMax" to "#cd6400",
        "Bluespec" to "#12223c",
        "Bluespec BH" to "#12223c",
        "Boo" to "#d4bec1",
        "Boogie" to "#c80fa0",
        "BQN" to "#2b7067",
        "Brainfuck" to "#2F2530",
        "BrighterScript" to "#66AABB",
        "Brightscript" to "#662D91",
        "Browserslist" to "#ffd539",
        "C" to "#555555",
        "C#" to "#178600",
        "C++" to "#f34b7d",
        "C2hs Haskell" to null,
        "Cabal Config" to "#483465",
        "Caddyfile" to "#22b638",
        "Cadence" to "#00ef8b",
        "Cairo" to "#ff4a48",
        "Cairo Zero" to "#ff4a48",
        "CameLIGO" to "#3be133",
        "CAP CDS" to "#0092d1",
        "Cap'n Proto" to "#c42727",
        "Carbon" to "#222222",
        "CartoCSS" to null,
        "Ceylon" to "#dfa535",
        "Chapel" to "#8dc63f",
        "Charity" to null,
        "ChucK" to "#3f8000",
        "Circom" to "#707575",
        "Cirru" to "#ccccff",
        "Clarion" to "#db901e",
        "Clarity" to "#5546ff",
        "Classic ASP" to "#6a40fd",
        "Clean" to "#3F85AF",
        "Click" to "#E4E6F3",
        "CLIPS" to "#00A300",
        "Clojure" to "#db5855",
        "Closure Templates" to "#0d948f",
        "Cloud Firestore Security Rules" to "#FFA000",
        "CMake" to "#DA3434",
        "COBOL" to null,
        "CodeQL" to "#140f46",
        "CoffeeScript" to "#244776",
        "ColdFusion" to "#ed2cd6",
        "ColdFusion CFC" to "#ed2cd6",
        "COLLADA" to "#F1A42B",
        "Common Lisp" to "#3fb68b",
        "Common Workflow Language" to "#B5314C",
        "Component Pascal" to "#B0CE4E",
        "Cool" to null,
        "Coq" to "#d0b68c",
        "crontab" to "#ead7ac",
        "Crystal" to "#000100",
        "CSON" to "#244776",
        "Csound" to "#1a1a1a",
        "Csound Document" to "#1a1a1a",
        "Csound Score" to "#1a1a1a",
        "CSS" to "#663399",
        "CSV" to "#237346",
        "Cuda" to "#3A4E3A",
        "CUE" to "#5886E1",
        "Curry" to "#531242",
        "CWeb" to "#00007a",
        "Cycript" to null,
        "Cylc" to "#00b3fd",
        "Cypher" to "#34c0eb",
        "Cython" to "#fedf5b",
        "D" to "#ba595e",
        "D2" to "#526ee8",
        "Dafny" to "#FFEC25",
        "Darcs Patch" to "#8eff23",
        "Dart" to "#00B4AB",
        "DataWeave" to "#003a52",
        "Debian Package Control File" to "#D70751",
        "DenizenScript" to "#FBEE96",
        "Dhall" to "#dfafff",
        "DIGITAL Command Language" to null,
        "DirectX 3D File" to "#aace60",
        "DM" to "#447265",
        "Dockerfile" to "#384d54",
        "Dogescript" to "#cca760",
        "Dotenv" to "#e5d559",
        "DTrace" to null,
        "Dune" to "#89421e",
        "Dylan" to "#6c616e",
        "E" to "#ccce35",
        "Earthly" to "#2af0ff",
        "Easybuild" to "#069406",
        "eC" to "#913960",
        "Ecere Projects" to "#913960",
        "ECL" to "#8a1267",
        "ECLiPSe" to "#001d9d",
        "Ecmarkup" to "#eb8131",
        "Edge" to "#0dffe0",
        "EdgeQL" to "#31A7FF",
        "EditorConfig" to "#fff1f2",
        "Eiffel" to "#4d6977",
        "EJS" to "#a91e50",
        "Elixir" to "#6e4a7e",
        "Elm" to "#60B5CC",
        "Elvish" to "#55BB55",
        "Elvish Transcript" to "#55BB55",
        "Emacs Lisp" to "#c065db",
        "EmberScript" to "#FFF4F3",
        "EQ" to "#a78649",
        "Erlang" to "#B83998",
        "Euphoria" to "#FF790B",
        "F#" to "#b845fc",
        "F*" to "#572e30",
        "Factor" to "#636746",
        "Fancy" to "#7b9db4",
        "Fantom" to "#14253c",
        "Faust" to "#c37240",
        "Fennel" to "#fff3d7",
        "FIGlet Font" to "#FFDDBB",
        "Filebench WML" to "#F6B900",
        "Filterscript" to null,
        "FIRRTL" to "#2f632f",
        "fish" to "#4aae47",
        "Fluent" to "#ffcc33",
        "FLUX" to "#88ccff",
        "Forth" to "#341708",
        "Fortran" to "#4d41b1",
        "Fortran Free Form" to "#4d41b1",
        "FreeBASIC" to "#141AC9",
        "FreeMarker" to "#0050b2",
        "Frege" to "#00cafe",
        "Futhark" to "#5f021f",
        "G-code" to "#D08CF2",
        "Game Maker Language" to "#71b417",
        "GAML" to "#FFC766",
        "GAMS" to "#f49a22",
        "GAP" to "#0000cc",
        "GCC Machine Description" to "#FFCFAB",
        "GDB" to null,
        "GDScript" to "#355570",
        "GEDCOM" to "#003058",
        "Gemfile.lock" to "#701516",
        "Gemini" to "#ff6900",
        "Genero 4gl" to "#63408e",
        "Genero per" to "#d8df39",
        "Genie" to "#fb855d",
        "Genshi" to "#951531",
        "Gentoo Ebuild" to "#9400ff",
        "Gentoo Eclass" to "#9400ff",
        "Gerber Image" to "#d20b00",
        "Gherkin" to "#5B2063",
        "Git Attributes" to "#F44D27",
        "Git Config" to "#F44D27",
        "Git Revision List" to "#F44D27",
        "Gleam" to "#ffaff3",
        "Glimmer JS" to "#F5835F",
        "Glimmer TS" to "#3178c6",
        "GLSL" to "#5686a5",
        "Glyph" to "#c1ac7f",
        "Gnuplot" to "#f0a9f0",
        "Go" to "#00ADD8",
        "Go Checksums" to "#00ADD8",
        "Go Module" to "#00ADD8",
        "Go Workspace" to "#00ADD8",
        "Godot Resource" to "#355570",
        "Golo" to "#88562A",
        "Gosu" to "#82937f",
        "Grace" to "#615f8b",
        "Gradle" to "#02303a",
        "Gradle Kotlin DSL" to "#02303a",
        "Grammatical Framework" to "#ff0000",
        "GraphQL" to "#e10098",
        "Graphviz (DOT)" to "#2596be",
        "Groovy" to "#4298b8",
        "Groovy Server Pages" to "#4298b8",
        "GSC" to "#FF6800",
        "Hack" to "#878787",
        "Haml" to "#ece2a9",
        "Handlebars" to "#f7931e",
        "HAProxy" to "#106da9",
        "Harbour" to "#0e60e3",
        "Hare" to "#9d7424",
        "Haskell" to "#5e5086",
        "Haxe" to "#df7900",
        "HCL" to "#844FBA",
        "HiveQL" to "#dce200",
        "HLSL" to "#aace60",
        "HOCON" to "#9ff8ee",
        "HolyC" to "#ffefaf",
        "hoon" to "#00b171",
        "Hosts File" to "#308888",
        "HTML" to "#e34c26",
        "HTML+ECR" to "#2e1052",
        "HTML+EEX" to "#6e4a7e",
        "HTML+ERB" to "#701516",
        "HTML+PHP" to "#4f5d95",
        "HTML+Razor" to "#512be4",
        "HTTP" to "#005C9C",
        "HXML" to "#f68712",
        "Hy" to "#7790B2",
        "HyPhy" to null,
        "iCalendar" to "#ec564c",
        "IDL" to "#a3522f",
        "Idris" to "#b30000",
        "Ignore List" to "#000000",
        "IGOR Pro" to "#0000cc",
        "ImageJ Macro" to "#99AAFF",
        "Imba" to "#16cec6",
        "Inform 7" to null,
        "INI" to "#d1dbe0",
        "Ink" to null,
        "Inno Setup" to "#264b99",
        "Io" to "#a9188d",
        "Ioke" to "#078193",
        "Isabelle" to "#FEFE00",
        "Isabelle ROOT" to "#FEFE00",
        "ISPC" to "#2D68B1",
        "J" to "#9EEDFF",
        "Jai" to "#ab8b4b",
        "Janet" to "#0886a5",
        "JAR Manifest" to "#b07219",
        "Jasmin" to "#d03600",
        "Java" to "#b07219",
        "Java Properties" to "#2A6277",
        "Java Server Pages" to "#2A6277",
        "Java Template Engine" to "#2A6277",
        "JavaScript" to "#f1e05a",
        "JavaScript+ERB" to "#f1e05a",
        "JCL" to "#d90e09",
        "Jest Snapshot" to "#15c213",
        "JetBrains MPS" to "#21D789",
        "JFlex" to "#DBCA00",
        "Jinja" to "#a52a22",
        "Jison" to "#56b3cb",
        "Jison Lex" to "#56b3cb",
        "Jolie" to "#843179",
        "jq" to "#c7254e",
        "JSON" to "#292929",
        "JSON with Comments" to "#292929",
        "JSON5" to "#267CB9",
        "JSONiq" to "#40d47e",
        "JSONLD" to "#0c479c",
        "Jsonnet" to "#0064bd",
        "Julia" to "#a270ba",
        "Julia REPL" to "#a270ba",
        "Jupyter Notebook" to "#DA5B0B",
        "Just" to "#384d54",
        "Kaitai Struct" to "#773b37",
        "KakouneScript" to "#6f8042",
        "KDL" to "#ffb3b3",
        "KerboScript" to "#41adf0",
        "KiCad Layout" to "#2f4aab",
        "KiCad Legacy Layout" to "#2f4aab",
        "KiCad Schematic" to "#2f4aab",
        "Kotlin" to "#A97BFF",
        "KRL" to "#28430A",
        "kvlang" to "#1da6e0",
        "LabVIEW" to "#fede06",
        "Lark" to "#2980B9",
        "Lasso" to "#999999",
        "Latte" to "#f2a542",
        "Lean" to null,
        "Lean 4" to null,
        "Less" to "#1d365d",
        "Lex" to "#DBCA00",
        "LFE" to "#4C3023",
        "LigoLANG" to "#0e74ff",
        "LilyPond" to "#9ccc7c",
        "Limbo" to null,
        "Linear Programming" to null,
        "Linker Script" to null,
        "Liquid" to "#67b8de",
        "Literate Agda" to "#315665",
        "Literate CoffeeScript" to "#244776",
        "Literate Haskell" to "#5e5086",
        "LiveCode Script" to "#0c5ba5",
        "LiveScript" to "#499886",
        "LLVM" to "#185619",
        "Logos" to null,
        "Logtalk" to "#295b9a",
        "LOLCODE" to "#cc9900",
        "LookML" to "#652B81",
        "LoomScript" to null,
        "LSL" to "#3d9970",
        "Lua" to "#000080",
        "Luau" to "#00A2FF",
        "M" to null,
        "M4" to null,
        "M4Sugar" to null,
        "Macaulay2" to "#d8ffff",
        "Makefile" to "#427819",
        "Mako" to "#7e858d",
        "Markdown" to "#083fa1",
        "Marko" to "#42bff2",
        "Mask" to "#f97732",
        "Mathematica" to "#dd1100",
        "MATLAB" to "#e16737",
        "Max" to "#c4a79c",
        "MAXScript" to "#00a6a6",
        "mcfunction" to "#E22837",
        "mdsvex" to "#5f9ea0",
        "MDX" to "#fcb32c",
        "Mercury" to "#ff2b2b",
        "Mermaid" to "#ff3670",
        "Meson" to "#007800",
        "Metal" to "#8f14e9",
        "MiniD" to null,
        "MiniYAML" to "#ff1111",
        "MiniZinc" to "#06a9e6",
        "Mint" to "#02b046",
        "Mirah" to "#c7a938",
        "mIRC Script" to "#3d57c3",
        "MLIR" to "#5EC8DB",
        "Modelica" to "#de1d31",
        "Modula-2" to "#10253f",
        "Modula-3" to "#223388",
        "Module Management System" to null,
        "Mojo" to "#ff4c1f",
        "Monkey" to null,
        "Monkey C" to "#8D6747",
        "Moocode" to null,
        "MoonBit" to "#b92381",
        "MoonScript" to "#ff4585",
        "Motoko" to "#fbb03b",
        "Motorola 68K Assembly" to "#005daa",
        "Move" to "#4a137a",
        "MQL4" to "#62A8D6",
        "MQL5" to "#4A76B8",
        "MTML" to "#b7e1f4",
        "MUF" to null,
        "mupad" to "#244963",
        "Mustache" to "#724b3b",
        "Myghty" to null,
        "nanorc" to "#2d004d",
        "Nasal" to "#1d2c4e",
        "NASL" to null,
        "NCL" to "#28431f",
        "Nearley" to "#990000",
        "Nemerle" to "#3d3c6e",
        "nesC" to "#94B0C7",
        "NetLinx" to "#0aa0ff",
        "NetLinx+ERB" to "#747faa",
        "NetLogo" to "#ff6375",
        "NewLisp" to "#87AED7",
        "Nextflow" to "#3ac486",
        "Nginx" to "#009639",
        "Nim" to "#ffc200",
        "Nit" to "#009917",
        "Nix" to "#7e7eff",
        "NMODL" to "#00356B",
        "Noir" to "#2f1f49",
        "NPM Config" to "#cb3837",
        "NSIS" to null,
        "Nu" to "#c9df40",
        "NumPy" to "#9C8AF9",
        "Nunjucks" to "#3d8137",
        "Nushell" to "#4E9906",
        "NWScript" to "#111522",
        "OASv2-json" to "#85ea2d",
        "OASv2-yaml" to "#85ea2d",
        "OASv3-json" to "#85ea2d",
        "OASv3-yaml" to "#85ea2d",
        "Oberon" to null,
        "Objective-C" to "#438eff",
        "Objective-C++" to "#6866fb",
        "Objective-J" to "#ff0c5a",
        "ObjectScript" to "#424893",
        "OCaml" to "#ef7a08",
        "Odin" to "#60AFFE",
        "Omgrofl" to "#cabbff",
        "OMNeT++ MSG" to "#a0e0a0",
        "OMNeT++ NED" to "#08607c",
        "ooc" to "#b0b77e",
        "Opa" to null,
        "Opal" to "#f7ede0",
        "Open Policy Agent" to "#7d9199",
        "OpenAPI Specification v2" to "#85ea2d",
        "OpenAPI Specification v3" to "#85ea2d",
        "OpenCL" to "#ed2e2d",
        "OpenEdge ABL" to "#5ce600",
        "OpenQASM" to "#AA70FF",
        "OpenRC runscript" to null,
        "OpenSCAD" to "#e5cd45",
        "Option List" to "#476732",
        "Org" to "#77aa99",
        "OverpassQL" to "#cce2aa",
        "Ox" to null,
        "Oxygene" to "#cdd0e3",
        "Oz" to "#fab738",
        "P4" to "#7055b5",
        "Pact" to "#F7A8B8",
        "Pan" to "#cc0000",
        "Papyrus" to "#6600cc",
        "Parrot" to "#f3ca0a",
        "Parrot Assembly" to null,
        "Parrot Internal Representation" to null,
        "Pascal" to "#E3F171",
        "Pawn" to "#dbb284",
        "PDDL" to "#0d00ff",
        "PEG.js" to "#234d6b",
        "Pep8" to "#C76F5B",
        "Perl" to "#0298c3",
        "PHP" to "#4F5D95",
        "PicoLisp" to "#6067af",
        "PigLatin" to "#fcd7de",
        "Pike" to "#005390",
        "Pip Requirements" to "#FFD343",
        "Pkl" to "#6b9543",
        "PlantUML" to "#fbbd16",
        "PLpgSQL" to "#336790",
        "PLSQL" to "#dad8d8",
        "PogoScript" to "#d80074",
        "Polar" to "#ae81ff",
        "Pony" to null,
        "Portugol" to "#f8bd00",
        "Praat" to null,
        "Prisma" to "#0c344b",
        "Processing" to "#0096D8",
        "Procfile" to "#3B2F63",
        "Prolog" to "#74283c",
        "Promela" to "#de0000",
        "Propeller Spin" to "#7fa2a7",
        "Pug" to "#a86454",
        "Puppet" to "#302B6D",
        "PureBasic" to "#5a6986",
        "PureScript" to "#1D222D",
        "Pyret" to "#ee1e10",
        "Python" to "#3572A5",
        "Python console" to "#3572A5",
        "Python traceback" to "#3572A5",
        "q" to "#0040cd",
        "Q#" to "#fed659",
        "QMake" to null,
        "QML" to "#44a51c",
        "Qt Script" to "#00b841",
        "Quake" to "#882233",
        "QuickBASIC" to "#008080",
        "R" to "#198ce7",
        "Racket" to "#222222",
        "Ragel" to "#9d5200",
        "Raku" to "#000000",
        "RAML" to "#77d9fb",
        "Rebol" to "#358a5b",
        "Record Jar" to "#0673ba",
        "Red" to "#f50000",
        "Redcode" to null,
        "Regular Expression" to "#009a00",
        "Ren'Py" to "#ff7f7f",
        "RenderScript" to null,
        "ReScript" to "#ed5051",
        "reStructuredText" to "#141414",
        "REXX" to "#d90e09",
        "Rez" to "#FFDAB3",
        "Ring" to "#2D54CB",
        "Riot" to "#A71E49",
        "RMarkdown" to "#198ce7",
        "RobotFramework" to "#00c0b5",
        "Roc" to "#7c38f5",
        "Roff" to "#ecdebe",
        "Roff Manpage" to "#ecdebe",
        "RON" to "#a62c00",
        "Rouge" to "#cc0088",
        "RouterOS Script" to "#DE3941",
        "Simple File Verification" to "#C9BFED",
        "Singularity" to "#64E6AD",
        "Slang" to "#1fbec9",
        "Slash" to "#007eff",
        "Slice" to "#003fa2",
        "Slim" to "#2b2b2b",
        "Slint" to "#2379F4",
        "Smali" to null,
        "Smalltalk" to "#596706",
        "Smarty" to "#f0c040",
        "Smithy" to "#c44536",
        "SmPL" to "#c94949",
        "SMT" to null,
        "Snakemake" to "#419179",
        "Solidity" to "#AA6746",
        "SourcePawn" to "#f69e1d",
        "SPARQL" to "#0C4597",
        "SQF" to "#3F3F3F",
        "SQL" to "#e38c00",
        "SQLPL" to "#e38c00",
        "Squirrel" to "#800000",
        "Stan" to "#b2011d",
        "Standard ML" to "#dc566d",
        "Stata" to "#1a5f91",
        "Stylus" to "#ff6347",
        "SubUnit" to "#2e9e37",
        "SuperCollider" to "#46390b",
        "Svelte" to "#ff3e00",
        "Swift" to "#F05138",
        "SystemVerilog" to "#DAE1C2",
        "Tcl" to "#e4cc98",
        "Tcsh" to "#008751",
        "TeX" to "#3D6117",
        "Thrift" to "#D12127",
        "TI Program" to "#A0AA87",
        "TLA+" to "#4A5B8C",
        "TSQL" to "#b50426",
        "TSX" to "#3178c6",
        "Text" to "#333333",
        "Tilt" to "#ff5a03",
        "Turing" to "#FF790B",
        "Twig" to "#c1d026",
        "TypeScript" to "#2b7489",
        "Unified Parallel C" to "#4e3617",
        "Uno" to "#3c9eff",
        "UnrealScript" to "#a54c4d",
        "UrWeb" to "#000000",
        "V" to "#4F87C4",
        "Vala" to "#fbe5cd",
        "Verilog" to "#b2b7f8",
        "VHDL" to "#adb2cb",
        "Vim script" to "#199f4b",
        "Visual Basic" to "#945db7",
        "Volt" to "#1F1F1F",
        "Vue" to "#41b883",
        "Wavefront Material" to "#231f20",
        "Wdl" to "#42f1f4",
        "Web Ontology Language" to "#9cc9dd",
        "WebAssembly" to "#04133b",
        "Wget Config" to "#5374a4",
        "Wisp" to "#7582D1",
        "Wollok" to "#a23738",
        "X10" to "#4B6BEF",
        "xBase" to "#403a40",
        "XC" to "#99DA07",
        "Xmake" to "#22a079",
        "XML" to "#0060ac",
        "XML Property List" to "#0060ac",
        "Xojo" to "#81bd41",
        "Xonsh" to "#285EEF",
        "XProc" to null,
        "XQuery" to "#5232e7",
        "XS" to null,
        "XSLT" to "#EB8CEB",
        "Xtend" to "#24255d",
        "Yacc" to "#4B6C4B",
        "YAML" to "#cb171e",
        "YARA" to "#220000",
        "YASnippet" to "#32AB90",
        "Yul" to "#794932",
        "ZAP" to "#0d665e",
        "Zeek" to null,
        "Zig" to "#f7a0be"
    )

    fun getColor(language: String?): String {
        return colors[language] ?: "#FF000000"
    }
}
