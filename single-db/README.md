# k8s-db

在Kubernetes中运行一个单实例有状态的应用(Spring boot + MySQL)， 详细部署参考 [https://tomoyadeng.github.io/blog/2018/09/16/springboot-k8s-2/](https://tomoyadeng.github.io/blog/2018/09/16/springboot-k8s-2/)

## 部署

```bash
cd deployment

# 1. 创建 PV
kubectl create -f local-volume.yaml

# 2. 创建 secrete
kubectl create -f mysql-secret.yaml

# 3. 部署 MySQL
kubectl create -f mysql-deployment.yaml

# 4. 部署 k8s-db 服务
kubectl create -f k8s-db.yaml
```
