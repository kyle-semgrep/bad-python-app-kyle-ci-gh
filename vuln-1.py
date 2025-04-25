<<<<<<< HEAD
# comment for PR purposes...

=======
# Commments to trigger PR
>>>>>>> 8561568557a65eb8fe5acb5f741b5c2bb01a46b8
import os
import flask

app = flask.Flask(__name__)


@app.route("/route_param/<route_param>")
def route_param(route_param):

    # ruleid:dangerous-os-exec
    os.execl("/bin/bash", "/bin/bash", "-c", route_param)

    return "oops!"


# Flask true negatives
@app.route("/route_param/<route_param>")
def route_param2(route_param):

    # ok:dangerous-os-exec
    os.execl("static")

    return "ok!"
