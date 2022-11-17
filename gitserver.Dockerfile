FROM node:alpine

RUN apk add --no-cache tini git \
    && yarn global add git-http-server \
    && adduser -D -g TseKinPing TseKinPing

USER TseKinPing
WORKDIR /home/TseKinPing

RUN git init --bare repository.git

ENTRYPOINT ["tini", "--", "git-http-server", -p", "3000", "/home/git"]