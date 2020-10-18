# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

# Only allow for machines which start with "rpi"
#COMPATIBLE_MACHINE = "^rpi$"

# Install kodi and related components
IMAGE_INSTALL_append = " \
	kodi \
	libavfilter \
	libavformat \
	libswscale \
	libswresample \
	glibc-utils \
	localedef \
	connman connman-client \
	kodi-addon-libreelec-settings \
	curl \
	samba-base \
	setxkbmap \
	alsa-utils alsa-utils-speakertest \
	nano vim \
	transmission transmission-web \
"

IMAGE_INSTALL_append_rpi = "omxplayer"
IMAGE_INSTALL_append_cubox-i = " pulseaudio pulseaudio-server"

# Install language packs
IMAGE_INSTALL_append = " \
	glibc-gconv-cp1251 \
	glibc-charmap-cp1251 \
	glibc-gconv-big5 \
	glibc-charmap-big5 \
	glibc-charmap-iso-8859-9 \
	glibc-gconv-iso8859-9 \
	glibc-charmap-koi8-r \
	glibc-gconv-koi8-r \
	glibc-gconv-iso8859-2 \
	glibc-charmap-iso-8859-2 \
	glibc-gconv-iso8859-1 \
	glibc-charmap-iso-8859-1 \
	glibc-gconv-euc-kr \
	glibc-charmap-euc-kr \
	glibc-gconv-euc-jp \
	glibc-charmap-euc-jp \
	glibc-gconv-utf-16 \
	glibc-charmap-utf-8 \
	glibc-gconv-cp1255 \
	glibc-charmap-cp1255 \
	glibc-gconv-utf-32 \
	glibc-gconv-utf-7 \
	glibc-gconv-euc-jp \
	glibc-gconv-iso8859-1 \
	glibc-gconv-iso8859-15 \
	glibc-charmap-invariant \
	glibc-localedata-translit-cjk-variants \
        locale-base-bg-bg \
	locale-base-tr-tr \
	locale-base-lt-lt \
	locale-base-ja-jp.euc-jp \
	locale-base-fa-ir \
	locale-base-ru-ru \
	locale-base-de-de \
	locale-base-hr-hr \
	locale-base-el-gr \
	locale-base-fr-fr \
	locale-base-es-es \
	locale-base-en-gb \
	locale-base-en-us \
	locale-base-pl-pl \
	locale-base-pl-pl.iso-8859-2 \
"

# Enable SSH access
CORE_IMAGE_EXTRA_INSTALL += "openssh"

# Enable all languge support for subtitiles
# /usr/share/i18n/charmaps and /usr/lib/gconv
GLIBC_GENERATE_LOCALES = "all"
IMAGE_LINGUAS = "af-za ar-ae ar-bh ar-dz ar-eg ar-iq ar-jo ar-kw ar-lb ar-ly ar-ma ar-om ar-qa ar-sa ar-sy ar-tn ar-ye az-az be-by bg-bg bs-ba ca-es cs-cz cy-gb da-dk de-at de-ch de-de de-li de-lu dv-mv el-gr en-au en-ca en-gb en-ie en-nz en-ph en-us en-za en-zw es-ar es-bo es-cl es-co es-cr es-do es-ec es-es es-gt es-hn es-mx es-ni es-pa es-pe es-pr es-py es-sv es-uy es-ve et-ee eu-es fa-ir fi-fi fo-fo fr-be fr-ca fr-ch fr-fr fr-lu gl-es gu-in he-il hi-in hr-hr hu-hu hy-am id-id is-is it-ch it-it ja-jp ka-ge kk-kz kn-in ko-kr kok-in ky-kg lt-lt lv-lv mi-nz mk-mk mn-mn mr-in ms-my mt-mt nb-no nl-be nl-nl nn-no pa-in pl-pl pt-br pt-pt ro-ro ru-ru sa-in se-no sk-sk sl-si sq-al sv-fi sv-se sw-ke ta-in te-in th-th tl-ph tn-za tr-tr tt-ru uk-ua ur-pk uz-uz vi-vn xh-za zh-cn zh-hk zh-sg zh-tw zu-za" 
