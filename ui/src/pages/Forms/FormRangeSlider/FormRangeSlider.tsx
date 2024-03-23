import React from "react";
import { Card, Col, Row, CardHeader, Container, Form, CardBody } from "reactstrap";
//import Components
import BreadCrumb from "../../../Components/Common/BreadCrumb";
const FormRangeSlider = () => {


  return (
    <React.Fragment>

      <div className="page-content">

        <title>
          Range Slider | Velzon - React Admin & Dashboard Template
        </title>

        <Container fluid>
          <BreadCrumb title="Range Slider" pageTitle="Forms" />

          <Row>
            <Col lg={12}>
              <Card>
                <CardHeader className="align-items-center d-flex">
                  <h4 className="card-title mb-0 flex-grow-1">Bootstrap Range</h4>
                </CardHeader>

                <CardBody>
                  <div className="live-preview">
                    <div>
                      <div>
                        <h5 className="fs-14">Default Range</h5>
                        <p className="text-muted">Use <code>form-range</code> class to create a default range.</p>

                        <Form>
                          <input type="range" className="form-range" id="customRange1" />
                        </Form>
                      </div>

                      <div className="mt-4">
                        <h5 className="fs-14">Disabled</h5>
                        <p className="text-muted">Use <code>disabled</code> attribute on an input to give it a grayed out appearance and remove pointer events.</p>

                        <Form>
                          <input type="range" className="form-range" id="disabledRange" disabled />
                        </Form>
                      </div>

                      <div className="mt-4">
                        <h5 className="fs-14">Min and Max</h5>
                        <p className="text-muted">Use <code>min</code> and <code>max</code> attribute with specified range input respectively.</p>

                        <Form>
                          <input type="range" className="form-range" min="0" max="5" id="customRange2" />
                        </Form>
                      </div>

                      <div className="mt-4">
                        <h5 className="fs-14">Steps</h5>
                        <p className="text-muted">By default, range inputs "snap" to integer values. To change this, you can specify a step value. In the example below, we double the number of steps by using <code>step="0.5"</code> attribute.</p>

                        <Form>
                          <input type="range" className="form-range" min="0" max="5" step="0.5" id="customRange3" />
                        </Form>
                      </div>
                    </div>
                  </div>
                </CardBody>
              </Card>
            </Col>
          </Row>
        </Container>
      </div>
    </React.Fragment>
  );
};

export default FormRangeSlider;
