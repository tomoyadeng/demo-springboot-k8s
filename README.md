# demo-springboot-k8s
A demo for deploy spring boot application in Kubernetes

### Build

```bash
gradle clean build buildDocker
```

### Deploy

```bash
kubectl create -f k8s-service/deployment/k8s-service.yaml

kubectl expose deployment k8s-service --type=LoadBalancer
```

### Verification

```bash
curl $(minikube service k8s-service --url)/hello
```
