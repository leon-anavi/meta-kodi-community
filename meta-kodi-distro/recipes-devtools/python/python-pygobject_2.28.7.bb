DESCRIPTION = "Python GObject bindings"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a916467b91076e631dd8edb7424769c7"

DEPENDS = "python-pygobject-native glib-2.0"
PR = "ml0"

inherit gnomebase autotools distutils-base pkgconfig

SRCNAME="pygobject"
SRC_URI = " \
	http://ftp.gnome.org/pub/GNOME/sources/${SRCNAME}/${@gnome_verdir("${PV}")}/${SRCNAME}-${PV}.tar.xz \
	file://pygobject-0001-add-PYTHON_INCLUDES-override.patch \
"
SRC_URI[md5sum] = "ae48b60c690c4aa894e69e0c97802745"
SRC_URI[sha256sum] = "bb9d25a3442ca7511385a7c01b057492095c263784ef31231ffe589d83a96a5a"
S = "${WORKDIR}/pygobject-${PV}"

FILESPATH = "${FILE_DIRNAME}/python-pygobject:${FILE_DIRNAME}/files"

# necessary to let the call for python-config succeed
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

PACKAGES += "${PN}-lib"

RDEPENDS_${PN} += "python-textutils"

FILES_${PN} = "${libdir}/python*"
FILES_${PN}-lib = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir} ${datadir}"
FILES_${PN}-dbg += "${libdir}/.debug"

BBCLASSEXTEND = "native"
PACKAGECONFIG_class-native = ""
