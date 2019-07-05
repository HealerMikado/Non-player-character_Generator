FROM nginx
COPY build /usr/share/nginx/html
RUN rm etc/nginx/conf.d/default.conf
COPY nginx-js.conf etc/nginx/conf.d/
