# Custom ls commands implementation in JAVA
@ author JunPyo Seo 21800370

------------

## About Program

* This program provide ls command in Unix- with 5 additional options.

* This program using gradle dist package.

* You can use ` -na` , `-c` option with any other commands but recommend others should be used alone except ` -na` and `-c`


## Usage ##


 with NO OPTION : basically shows name of the files.

`-c` Set the custom path for ls commands. if you not , default is current directory.

`-F` appends a character revealing the nature of a file, for example, * for an executable, or / for a directory. Regular files have no suffix.

`-na` Show the result of files which are not hidden files.

`-m` Show the last modified date in day format ` ("MM/dd/yyyy HH:mm:ss")`

`-s` Show the files names with size of the file.

`-help` Print help page.
