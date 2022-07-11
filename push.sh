gradle jibDockerBuild
docker tag mushroom:0.0.1-SNAPSHOT asia-northeast3-docker.pkg.dev/tfit-271908/mushroom/mushroom:0.0.1-SNAPSHOT
docker push asia-northeast3-docker.pkg.dev/tfit-271908/mushroom/mushroom:0.0.1-SNAPSHOT
gcloud run deploy mushroom --image asia-northeast3-docker.pkg.dev/tfit-271908/mushroom/mushroom:0.0.1-SNAPSHOT --platform managed