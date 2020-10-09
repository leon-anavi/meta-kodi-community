FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://settings"

do_install_append() {
	install -d ${D}${localstatedir}/lib/connman
	install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman/settings

	install -d ${D}${sysconfdir}/connman
	install -m 0644 ${S}/src/main.conf ${D}${sysconfdir}/connman/main.conf
	sed -i ${D}${sysconfdir}/connman/main.conf \
	-e "s|^# BackgroundScanning.*|BackgroundScanning = true|g" \
	-e "s|^# UseGatewaysAsTimeservers.*|UseGatewaysAsTimeservers = false|g" \
	-e "s|^# FallbackNameservers.*|FallbackNameservers = 8.8.8.8,8.8.4.4|g" \
	-e "s|^# FallbackTimeservers.*|FallbackTimeservers = 0.pool.ntp.org,1.pool.ntp.org,2.pool.ntp.org,3.pool.ntp.org|g" \
	-e "s|^# PreferredTechnologies.*|PreferredTechnologies = ethernet,wifi,cellular|g" \
	-e "s|^# TetheringTechnologies.*|TetheringTechnologies = wifi|g" \
	-e "s|^# AllowHostnameUpdates.*|AllowHostnameUpdates = false|g" \
	-e "s|^# PersistentTetheringMode.*|PersistentTetheringMode = true|g" \
	-e "s|^# NetworkInterfaceBlacklist = vmnet,vboxnet,virbr,ifb|NetworkInterfaceBlacklist = vmnet,vboxnet,virbr,ifb,docker,veth,zt|g"
}

FILES_${PN} += "${sysconfdir}/connman/main.conf"
