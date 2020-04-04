FROM daggerok/jboss-eap-7.2:7.2.5-alpine
EXPOSE 8080
HEALTHCHECK --interval=3s --timeout=3s --retries=33 \
        CMD ( wget -q --spider http://127.0.0.1:8080/webapp1/hello/ \
         &&   wget -q --spider http://127.0.0.1:8080/webapp2/hello/ ) || exit 1
COPY --chown=jboss ./target/*.ear ${JBOSS_HOME}/standalone/deployments/ROOT.ear
