# Spring API Starter

Starter project to create API with java 11 and Spring boot. API first designed. 

# API Documentation

See [Redoc / Openapi Documentation](https://remyranger.github.io/spring-api-starter/) to see how it works.

# Required

* JAVA 11
* MySQL db
* Task (to generate documentation): https://taskfile.dev/

# Generate Documentation (optional)

To build all OpenAPI bundles to one unique file and generate static html file documentation.
`task generate_docs`

File generated in /doc/dist is used by Maven for interface generation on build.
This step is optional, the final file is already commited in /doc/dist.