SUMMARY = "Simple HelloWorld Application"
DESCRIPTION = "A test application to demonstrate how to create a recipe by directly compiling C files with BitBake"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://hello-1.0.tgz"


S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile(){
    ${CC} -c helloprint.c
    ${CC} -c hello.c
    ${CC} -o hello hello.o helloprint.o
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 hello ${D}${bindir}
}
