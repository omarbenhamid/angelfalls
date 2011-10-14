■Angel Falls  

■はじめに
オープンソースでプロジェクトをガントチャートで管理できるソフトウェアとして、OpenProjがあります。
しかしながら、メンテナンスが全くされていない。バグが多い(そもそもビルドできない)などOSSとしては問題
があります。Angel FallsはOpenProjをベースに、バグフィックスや機能拡張を行ったプロジェクト管理ソフトウェアです。

MS Projectと同じフィールでプロジェクトを管理することができます。また、Trac/Redminなどのチケットシステムとの
連携も視野に入れています。


■ビルド
■■準備
Angel Fallsは、Mavenリポジトリにないjarを利用します。下記のコマンドによりjarをMavenリポジトリへインストールしてください。

[Windows]
> install-jar.bat

[Linux]
$ install-jar.sh

■■ビルド
下記のコマンドで全てのモジュールがビルドされます。

$ mvn install

■■パッケージ作成
下記のコマンドを実行すると、AngelFalls-x.x.x.zipという名前で配布ファイルが作成されます。

$ cd pkg
$ mvn assembly:assembly

Java Web Start用のファイルを生成するには、pkgディレクトリで

$ mvn webstart:jnlp

と入力してください。target/jnlpディレクトリに署名済みのjarとjnlpファイルが作成されます。

■■実行
pkg/targetディレクトリに生成されたzipを展開して、binディレクトリの angelfalls.bat or kanon スリプトを実行します。


■謝辞
Angel FallsはSennaProjityにより開発されたOpenProjをもとに開発されています。
OpenProjについては、http://openproj.org/をご覧ください。
