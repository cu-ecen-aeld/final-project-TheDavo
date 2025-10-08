# this is an append file to use a previous version of libgpiod that
# was on the raspberry pi being tested, and not the latest and greatest version

PV = "1.6.3"
SRCREV = "dfc5d361e6748d5f48b706e5c4ac949d133b5470"
# SRC_URI = "git://git.kernel.org/pub/scm/libs/libgpiod/libgpiod.git;protocol=https;branch=main"
SRC_URI = "https://mirrors.edge.kernel.org/pub/software/libs/libgpiod/libgpiod-${PV}.tar.gz"
SRC_URI[sha256sum] = "0e6f375e2c748d518c1c960c967cf84c154a00501850861343203a0e34d217b7"
