import "./Footer.css";
import { Grid, Typography, Link, Button } from "@mui/material";

const Footer = () => {
  return (
    <footer className="root">
      <Grid className="text-white text-center mt-5" container alignItems="center">
        <Grid item xs={12} sm={6} md={3}>
          <Typography pb={5} variant="h7" align="left">
            <Button pb={5} variant="h6" className="Button">
              About
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Contact
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Privacy Policy
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Terms of Service
            </Button>
          </Typography>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Typography pb={5} variant="h7" align="left">
            <Button pb={5} variant="h6" className="link">
              About
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Contact
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Privacy Policy
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Terms of Service
            </Button>
          </Typography>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Typography pb={5} variant="h7" align="left">
            <Button pb={5} variant="h6" className="Button">
              About
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Contact
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Privacy Policy
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Terms of Service
            </Button>
          </Typography>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
        <Typography pb={5} variant="h7" align="left">
            <Button pb={5} variant="h6" className="Button">
              About
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Contact
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Privacy Policy
            </Button>
            <br />
            <Button pb={5} variant="h6" className="Button">
              Terms of Service
            </Button>
          </Typography>
        </Grid>
      </Grid>
      <Grid className="pt-20" item xs={12}>
          <Typography pb={5} variant="body2" component="p" align="center" gutterBottom>
            © 2024 Your Company. All rights reserved.
          </Typography>
          <Typography pb={5} variant="body2" component="p" align="center" gutterBottom>
            Made By Deepak
          </Typography>
        </Grid>
    </footer>
  );
};

export default Footer;
