SUMMARY = "The LibreELEC settings addon for KODI"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=58a5cc85534ec201eb2e77c3433d309e"

SRCREV = "ce44935c09668da545652b36a72d5f15857f0e18"

PV = "9.0.0"
SRC_URI = "git://github.com/LibreELEC/service.libreelec.settings.git;branch=libreelec-9.2;protocol=https \
          "

S = "${WORKDIR}/git"

KODIADDONNAME = "service.libreelec.settings"

DEPENDS += " \
	zip-native \
	p8platform \
	kodi-platform \
"

# Doesn't get added automagically, dlopen()?
RDEPENDS_${PN} = " \
	libkodiplatform \
	python-dbus \
	python-pygobject \
	connman \
"

do_compile () {
	oe_runmake addon
}

do_install () {
	install -d ${D}${datadir}/kodi/addons/
	cp -r ${S}/build/${KODIADDONNAME} ${D}${datadir}/kodi/addons/
	install -d ${D}${datadir}/kodi/addons/packages/
	install -m 0644 ${S}/build/${KODIADDONNAME}-${PV}.zip ${D}${datadir}/kodi/addons/packages/
}

INSANE_SKIP_${PN} = "dev-so"
FILES_${PN} += "${datadir}/kodi"
FILES_${PN}-dbg += "${datadir}/kodi/addons/*/.debug/"
